package com.cassandra;

import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.beans.OrderedRows;
import me.prettyprint.hector.api.beans.Row;
import me.prettyprint.hector.api.exceptions.HectorException;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.mutation.Mutator;
import me.prettyprint.hector.api.query.QueryResult;
import me.prettyprint.hector.api.query.RangeSlicesQuery;

public class UserSample  {
    
    private static StringSerializer stringSerializer = StringSerializer.get();
    
    public static void main(String[] args) throws Exception {
        
        Cluster cluster = HFactory.getOrCreateCluster("Test Cluster", "localhost:9160");

        Keyspace keyspaceOperator = HFactory.createKeyspace("devdb", cluster);
                
        try {
            Mutator<String> mutator = HFactory.createMutator(keyspaceOperator, stringSerializer);

            for (int i = 3; i < 20; i++) {            
                mutator
                .addInsertion(i+"", "person", HFactory.createStringColumn("fn", "abc" + i))
                .addInsertion(i+"", "person", HFactory.createStringColumn("ln", "def" + i));
            }
            mutator.execute();

            RangeSlicesQuery<String, String, String> rangeSlicesQuery = HFactory.createRangeSlicesQuery(keyspaceOperator, stringSerializer, stringSerializer, stringSerializer);
            rangeSlicesQuery.setColumnFamily("person");
            rangeSlicesQuery.setKeys("", "");
            rangeSlicesQuery.setRange("", "", false, 3);
            
            rangeSlicesQuery.setRowCount(11);
            QueryResult<OrderedRows<String, String, String>> result = rangeSlicesQuery.execute();
            OrderedRows<String, String, String> orderedRows = result.get();
            
            
            Row<String,String,String> lastRow = orderedRows.peekLast();

            System.out.println("Contents of rows: \n");                       
            for (Row<String, String, String> r : orderedRows) {
                System.out.println("   " + r);
            }
            System.out.println("Should have 11 rows: " + orderedRows.getCount());
            
            rangeSlicesQuery.setKeys(lastRow.getKey(), "");
            orderedRows = rangeSlicesQuery.execute().get();
            
            System.out.println("2nd page Contents of rows: \n");
            for (Row<String, String, String> row : orderedRows) {
                System.out.println("   " + row);
            }
            
        } catch (HectorException he) {
            he.printStackTrace();
        }
        cluster.getConnectionManager().shutdown();
    }

}
