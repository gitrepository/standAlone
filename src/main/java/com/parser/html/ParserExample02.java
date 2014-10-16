package com.parser.html;

import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities.EscapeMode;
import org.jsoup.select.Elements;

public class ParserExample02 {

	public static void main(String[] args) {
		try {
			String[] strArray = {"GS","AAPL","JMP","GOOG"};
			String ticket = "GS";
//			for(int i=0; i < strArray.length; i++){
//				ticket = strArray[i];
//				Document doc = Jsoup.connect("http://finance.yahoo.com/q/ks?s="+ticket+"+Key+Statistics").get();
//				
//				String searchStr = "Price/Sales (ttm)";
//	        	System.out.println(ticket+" \t "+searchStr+" = "+getValueFromVTable(doc, searchStr));
//				searchStr = "Price/Book (mrq)";
//	        	System.out.println(ticket+" \t "+searchStr+" = "+getValueFromVTable(doc, searchStr));
//				searchStr = "Market Cap (intraday)";
//	        	System.out.println(ticket+" \t "+searchStr+" = "+getValueFromVTable(doc, searchStr));
//	        	
//			}
			
			Connection _conn = Jsoup.connect("https://www.hillsborough.realforeclose.com/index.cfm?zaction=AUCTION&zmethod=PREVIEW&AuctionDate=2013-06-19").url("https://www.hillsborough.realforeclose.com/index.cfm?zaction=AUCTION&Zmethod=UPDATE&FNC=LOAD&AREA=C&PageDir=0&doR=1");
			Document doc = _conn.get();
			System.out.println(doc);

			doc.outputSettings().escapeMode(EscapeMode.xhtml);
			doc.outputSettings().charset("UTF-8");
			
			String str = "<a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17992198\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA000107A001HC<\\a>Parcel ID:@F @CAD_DTA\">";
			str = str.replace("\\\\", "\\");
	//		String str = "<div id=\"AITEM_552875\" @C@E_ITEM PREVIEW\" aid=\"552875\" rem=\"0\" isset=\"0\">@D@A@E_STATS\">@AASTAT_MSGA ASTAT_LBL\">@B@AASTAT_MSGB Astat_DATA\">@B@AASTAT_MSGC ASTAT_LBL\">@B @AASTAT_MSGD Astat_DATA\">@B@AASTAT_MSG_SOLDTO_Label ASTAT_LBL\">@B@AASTAT_MSG_SOLDTO_MSG Astat_DATA\">@B@B@A@E_DETAILS\"> <@I @Cad_tab\">@H@CAD_LBL\">Auction Type:@F @CAD_DTA\">FORECLOSURE@G@H@CAD_LBL\">Case #:@F @CAD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17992198\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA000107A001HC<\\a> @G@H@CAD_LBL\">Final Judgment Amount:@F @CAD_DTA\">$268,205.65@G@H@CAD_LBL\">Parcel ID:@F @CAD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=20303264I000009000470U\" onClick = \"return showExitPopup();\" target=\"_blank\">20303264I000009000470U<\\a> @G@H@CAD_LBL\">Property Address:@F @CAD_DTA\">11750 CREST CREEK DR@G@H@CAD_LBL\">@F @CAD_DTA\">RIVERVIEW, 33569@G@H@CAD_LBL\">Assessed Value:@F @CAD_DTA\">$68,437.00@G@H@CAD_LBL\">Plaintiff Max Bid:@F @CAD_DTA ASTAT_MSGPB\">Hidden@G<\\@I>@B@B @B@A@E_ITEM_SPACER\">&nbsp;@B<div id=\"AITEM_555942\" @C@E_ITEM PREVIEW\" aid=\"555942\" rem=\"0\" isset=\"0\">@D@A@E_STATS\">@AASTAT_MSGA ASTAT_LBL\">@B@AASTAT_MSGB Astat_DATA\">@B@AASTAT_MSGC ASTAT_LBL\">@B @AASTAT_MSGD Astat_DATA\">@B@AASTAT_MSG_SOLDTO_Label ASTAT_LBL\">@B@AASTAT_MSG_SOLDTO_MSG Astat_DATA\">@B@B@A@E_DETAILS\"> <@I @Cad_tab\">@H@CAD_LBL\">Auction Type:@F @CAD_DTA\">FORECLOSURE@G@H@CAD_LBL\">Case #:@F @CAD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17627841\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA005705A001HC<\\a> @G@H@CAD_LBL\">Final Judgment Amount:@F @CAD_DTA\">$203,516.77@G@H@CAD_LBL\">Parcel ID:@F @CAD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=\" onClick = \"return showExitPopup();\" target=\"_blank\">Property Appraiser<\\a> @G@H@CAD_LBL\">Property Address:@F @CAD_DTA\">10110 WINSFORD OAK BLVD #602@G@H@CAD_LBL\">@F @CAD_DTA\">TAMPA, 33624@G@H@CAD_LBL\">Plaintiff Max Bid:@F @CAD_DTA ASTAT_MSGPB\">Hidden@G<\\@I>@B@B @B@A@E_ITEM_SPACER\">&nbsp;@B<div id=\"AITEM_551713\" @C@E_ITEM PREVIEW\" aid=\"551713\" rem=\"0\" isset=\"0\">@D@A@E_STATS\">@AASTAT_MSGA ASTAT_LBL\">@B@AASTAT_MSGB Astat_DATA\">@B@AASTAT_MSGC ASTAT_LBL\">@B @AASTAT_MSGD Astat_DATA\">@B@AASTAT_MSG_SOLDTO_Label ASTAT_LBL\">@B@AASTAT_MSG_SOLDTO_MSG Astat_DATA\">@B@B@A@E_DETAILS\"> <@I @Cad_tab\">@H@CAD_LBL\">Auction Type:@F @CAD_DTA\">FORECLOSURE@G@H@CAD_LBL\">Case #:@F @CAD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17985824\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA008349A001HC<\\a> @G@H@CAD_LBL\">Final Judgment Amount:@F @CAD_DTA\">$301,727.74@G@H@CAD_LBL\">Parcel ID:@F @CAD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=18282289N000000023010U\" onClick = \"return showExitPopup();\" target=\"_blank\">18282289N000000023010U<\\a> @G@H@CAD_LBL\">Property Address:@F @CAD_DTA\">8736 KEY BISCAYNE DR #102@G@H@CAD_LBL\">@F @CAD_DTA\">TAMPA, 33614@G@H@CAD_LBL\">Assessed Value:@F @CAD_DTA\">$39,192.00@G@H@CAD_LBL\">Plaintiff Max Bid:@F @CAD_DTA ASTAT_MSGPB\">Hidden@G<\\@I>@B@B @B@A@E_ITEM_SPACER\">&nbsp;@B<div id=\"AITEM_507938\" @C@E_ITEM PREVIEW\" aid=\"507938\" rem=\"0\" isset=\"0\">@D@A@E_STATS\">@AASTAT_MSGA ASTAT_LBL\">@B@AASTAT_MSGB Astat_DATA\">@B@AASTAT_MSGC ASTAT_LBL\">@B @AASTAT_MSGD Astat_DATA\">@B@AASTAT_MSG_SOLDTO_Label ASTAT_LBL\">@B@AASTAT_MSG_SOLDTO_MSG Astat_DATA\">@B@B@A@E_DETAILS\"> <@I @Cad_tab\">@H@CAD_LBL\">Auction Type:@F @CAD_DTA\">FORECLOSURE@G@H@CAD_LBL\">Case #:@F @CAD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17726852\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA014917A001HC<\\a> @G@H@CAD_LBL\">Final Judgment Amount:@F @CAD_DTA\">$253,225.58@G@H@CAD_LBL\">Parcel ID:@F @CAD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=203103ZZZ000003108800U\" onClick = \"return showExitPopup();\" target=\"_blank\">203103ZZZ000003108800U<\\a> @G@H@CAD_LBL\">Property Address:@F @CAD_DTA\">12701 BALM RIVERVIEW RD@G@H@CAD_LBL\">@F @CAD_DTA\">RIVERVIEW, 33579@G@H@CAD_LBL\">Assessed Value:@F @CAD_DTA\">$90,016.00@G@H@CAD_LBL\">Plaintiff Max Bid:@F @CAD_DTA ASTAT_MSGPB\">Hidden@G<\\@I>@B@B @B@A@E_ITEM_SPACER\">&nbsp;@B<div id=\"AITEM_555936\" @C@E_ITEM PREVIEW\" aid=\"555936\" rem=\"0\" isset=\"0\">@D@A@E_STATS\">@AASTAT_MSGA ASTAT_LBL\">@B@AASTAT_MSGB Astat_DATA\">@B@AASTAT_MSGC ASTAT_LBL\">@B @AASTAT_MSGD Astat_DATA\">@B@AASTAT_MSG_SOLDTO_Label ASTAT_LBL\">@B@AASTAT_MSG_SOLDTO_MSG Astat_DATA\">@B@B@A@E_DETAILS\"> <@I @Cad_tab\">@H@CAD_LBL\">Auction Type:@F @CAD_DTA\">FORECLOSURE@G@H@CAD_LBL\">Case #:@F @CAD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=14998525\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA017760A001HC<\\a> @G@H@CAD_LBL\">Final Judgment Amount:@F @CAD_DTA\">$395,762.17@G@H@CAD_LBL\">Parcel ID:@F @CAD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=222910ZZZ000004893200U\" onClick = \"return showExitPopup();\" target=\"_blank\">222910ZZZ000004893200U<\\a> @G@H@CAD_LBL\">Property Address:@F @CAD_DTA\">3006 JAP TUCKER RD@G@H@CAD_LBL\">@F @CAD_DTA\">PLANT CITY, 33566@G@H@CAD_LBL\">Assessed Value:@F @CAD_DTA\">$137,239.00@G@H@CAD_LBL\">Plaintiff Max Bid:@F @CAD_DTA ASTAT_MSGPB\">Hidden@G<\\@I>@B@B @B@A@E_ITEM_SPACER\">&nbsp;@B<div id=\"AITEM_566511\" @C@E_ITEM PREVIEW\" aid=\"566511\" rem=\"0\" isset=\"0\">@D@A@E_STATS\">@AASTAT_MSGA ASTAT_LBL\">@B@AASTAT_MSGB Astat_DATA\">@B@AASTAT_MSGC ASTAT_LBL\">@B @AASTAT_MSGD Astat_DATA\">@B@AASTAT_MSG_SOLDTO_Label ASTAT_LBL\">@B@AASTAT_MSG_SOLDTO_MSG Astat_DATA\">@B@B@A@E_DETAILS\"> <@I @Cad_tab\">@H@CAD_LBL\">Auction Type:@F @CAD_DTA\">FORECLOSURE@G@H@CAD_LBL\">Case #:@F @CAD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17999577\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA020290A001HC<\\a> @G@H@CAD_LBL\">Final Judgment Amount:@F @CAD_DTA\">$337,652.38@G@H@CAD_LBL\">Parcel ID:@F @CAD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=\" onClick = \"return showExitPopup();\" target=\"_blank\">Property Appraiser<\\a> @G@H@CAD_LBL\">Property Address:@F @CAD_DTA\">SEE FINAL JUDGMENT@G@H@CAD_LBL\">Plaintiff Max Bid:@F @CAD_DTA ASTAT_MSGPB\">Hidden@G<\\@I>@B@B @B@A@E_ITEM_SPACER\">&nbsp;@B<div id=\"AITEM_553248\" @C@E_ITEM PREVIEW\" aid=\"553248\" rem=\"0\" isset=\"0\">@D@A@E_STATS\">@AASTAT_MSGA ASTAT_LBL\">@B@AASTAT_MSGB Astat_DATA\">@B@AASTAT_MSGC ASTAT_LBL\">@B @AASTAT_MSGD Astat_DATA\">@B@AASTAT_MSG_SOLDTO_Label ASTAT_LBL\">@B@AASTAT_MSG_SOLDTO_MSG Astat_DATA\">@B@B@A@E_DETAILS\"> <@I @Cad_tab\">@H@CAD_LBL\">Auction Type:@F @CAD_DTA\">FORECLOSURE@G@H@CAD_LBL\">Case #:@F @CAD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA024628A001HC<\\a> @G@H@CAD_LBL\">Final Judgment Amount:@F @CAD_DTA\">$0.00@G@H@CAD_LBL\">Parcel ID:@F @CAD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=\" onClick = \"return showExitPopup();\" target=\"_blank\">Property Appraiser<\\a> @G@H@CAD_LBL\">Plaintiff Max Bid:@F @CAD_DTA ASTAT_MSGPB\">Hidden@G<\\@I>@B@B @B@A@E_ITEM_SPACER\">&nbsp;@B<div id=\"AITEM_505132\" @C@E_ITEM PREVIEW\" aid=\"505132\" rem=\"0\" isset=\"0\">@D@A@E_STATS\">@AASTAT_MSGA ASTAT_LBL\">@B@AASTAT_MSGB Astat_DATA\">@B@AASTAT_MSGC ASTAT_LBL\">@B @AASTAT_MSGD Astat_DATA\">@B@AASTAT_MSG_SOLDTO_Label ASTAT_LBL\">@B@AASTAT_MSG_SOLDTO_MSG Astat_DATA\">@B@B@A@E_DETAILS\"> <@I @Cad_tab\">@H@CAD_LBL\">Auction Type:@F @CAD_DTA\">FORECLOSURE@G@H@CAD_LBL\">Case #:@F @CAD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17710703\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA025007A001HC<\\a> @G@H@CAD_LBL\">Final Judgment Amount:@F @CAD_DTA\">$176,852.38@G@H@CAD_LBL\">Parcel ID:@F @CAD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=2029252G0000004000110U\" onClick = \"return showExitPopup();\" target=\"_blank\">2029252G0000004000110U<\\a> @G@H@CAD_LBL\">Property Address:@F @CAD_DTA\">1409 DEW BLOOM ROAD@G@H@CAD_LBL\">@F @CAD_DTA\">VALRICO, 33594@G@H@CAD_LBL\">Assessed Value:@F @CAD_DTA\">$67,447.00@G@H@CAD_LBL\">Plaintiff Max Bid:@F @CAD_DTA ASTAT_MSGPB\">Hidden@G<\\@I>@B@B @B@A@E_ITEM_SPACER\">&nbsp;@B<div id=\"AITEM_524187\" @C@E_ITEM PREVIEW\" aid=\"524187\" rem=\"0\" isset=\"0\">@D@A@E_STATS\">@AASTAT_MSGA ASTAT_LBL\">@B@AASTAT_MSGB Astat_DATA\">@B@AASTAT_MSGC ASTAT_LBL\">@B @AASTAT_MSGD Astat_DATA\">@B@AASTAT_MSG_SOLDTO_Label ASTAT_LBL\">@B@AASTAT_MSG_SOLDTO_MSG Astat_DATA\">@B@B@A@E_DETAILS\"> <@I @Cad_tab\">@H@CAD_LBL\">Auction Type:@F @CAD_DTA\">FORECLOSURE@G@H@CAD_LBL\">Case #:@F @CAD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17818530\" onClick = \"return showExitPopup();\" target=\"_blank\">292010CA016896A001HC<\\a> @G@H@CAD_LBL\">Final Judgment Amount:@F @CAD_DTA\">$147,760.58@G@H@CAD_LBL\">Parcel ID:@F @CAD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=1829144PD000001000200A\" onClick = \"return showExitPopup();\" target=\"_blank\">1829144PD000001000200A<\\a> @G@H@CAD_LBL\">Property Address:@F @CAD_DTA\">1709 W PALMETTO ST@G@H@CAD_LBL\">@F @CAD_DTA\">TAMPA, 33607@G@H@CAD_LBL\">Assessed Value:@F @CAD_DTA\">$39,607.00@G@H@CAD_LBL\">Plaintiff Max Bid:@F @CAD_DTA ASTAT_MSGPB\">Hidden@G<\\@I>@B@B @B@A@E_ITEM_SPACER\">&nbsp;@B<div id=\"AITEM_553310\" @C@E_ITEM PREVIEW\" aid=\"553310\" rem=\"0\" isset=\"0\">@D@A@E_STATS\">@AASTAT_MSGA ASTAT_LBL\">@B@AASTAT_MSGB Astat_DATA\">@B@AASTAT_MSGC ASTAT_LBL\">@B @AASTAT_MSGD Astat_DATA\">@B@AASTAT_MSG_SOLDTO_Label ASTAT_LBL\">@B@AASTAT_MSG_SOLDTO_MSG Astat_DATA\">@B@B@A@E_DETAILS\"> <@I @Cad_tab\">@H@CAD_LBL\">Auction Type:@F @CAD_DTA\">FORECLOSURE@G@H@CAD_LBL\">Case #:@F @CAD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17423423\" onClick = \"return showExitPopup();\" target=\"_blank\">292010CA019345A001HC<\\a> @G@H@CAD_LBL\">Final Judgment Amount:@F @CAD_DTA\">$91,655.43@G@H@CAD_LBL\">Parcel ID:@F @CAD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=1928281L7000002002050U\" onClick = \"return showExitPopup();\" target=\"_blank\">1928281L7000002002050U<\\a> @G@H@CAD_LBL\">Property Address:@F @CAD_DTA\">7818 NIAGARA AV @G@H@CAD_LBL\">@F @CAD_DTA\">TAMPA, 33617@G@H@CAD_LBL\">Assessed Value:@F @CAD_DTA\">$22,309.00@G@H@CAD_LBL\">Plaintiff Max Bid:@F @CAD_DTA ASTAT_MSGPB\">Hidden@G<\\@I>@B@B @B@A@E_ITEM_SPACER\">&nbsp;@B";
			str = str.replace("&gt;", ">");
			str = str.replace("&lt;", "<");
			str = str.replace("&nbsp;", " ");
			doc = Jsoup.parse(str);
			
			Elements text = doc.select(":containsOwn(Parcel ID:)");
	        Iterator<Element> itr = text.iterator();
	        while(itr.hasNext()){
	        	Element p = (Element) itr.next();
	        	System.out.println(p);
	        	System.out.println(p.ownText());
	        }

			_conn = Jsoup.connect("http://finance.yahoo.com/q/hp?s=GS+Historical+Prices");
			doc = _conn.get();
			text = doc.select(":containsOwn(Start Date:)");
	        itr = text.iterator();
	        while(itr.hasNext()){
	        	Element p = (Element) itr.next();
	        	System.out.println(p);
	        	System.out.println(p.ownText());
	        }

	        
			//System.out.println(doc);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public static String getValueFromVTable(Document doc, String searchStr){
    	String res = "";
        Elements text = doc.select(":containsOwn("+searchStr+")");
        Iterator<Element> itr = text.iterator();
        while(itr.hasNext()){
        	Element p = ((Element) itr.next()).parent();
        	Elements c = p.children();
        	res = c.get(1).text();
        }
        return res;
    }
}
