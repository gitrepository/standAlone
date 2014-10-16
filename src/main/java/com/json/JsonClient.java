package com.json;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/*
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
*/
public class JsonClient {

	public static void main(String[] args) {
/*		
		JSONObject jsonObj = new JSONObject();
		
		//#1. DropDown list object
		JSONArray dropDownArray = new JSONArray();
		Map<String, String> dmap = new LinkedHashMap<String, String>();
		for(int i=0; i<2; i++){
			dmap.put("label", "Label - "+i); dmap.put("value", "value - "+i);
			prepareJSONObject(dropDownArray, dmap);
		}
		jsonObj.put("dropDown", dropDownArray);

		//#2. Table rows
		JSONArray tableArray = new JSONArray();
		Map<String, String> tmap = new LinkedHashMap<String, String>();
		for(int i=0; i<3; i++){
			tmap.put("col1", "Column Value"+i); tmap.put("col2", "Column Value"+i); tmap.put("col3", "Column Value"+i);
			prepareJSONObject(tableArray, tmap);
		}
		jsonObj.put("table", tableArray);

		System.out.println(jsonObj);
		
		String str = jsonObj.toString();
		
		JSONObject json = (JSONObject) JSONSerializer.toJSON(str);
		System.out.println(json.get("dropDown"));
//		{
//			"dropDown":[
//			            {"label":"Label - 0","value":"value - 0"},
//			            {"label":"Label - 1","value":"value - 1"}
//			            ],
//			"table":[
//			         {"col1":"Column Value0","col2":"Column Value0","col3":"Column Value0"},
//			         {"col1":"Column Value1","col2":"Column Value1","col3":"Column Value1"},
//			         {"col1":"Column Value2","col2":"Column Value2","col3":"Column Value2"}
//			         ]
//		}


		//String str1 = "{'retHTML':'<div id=\"AITEM_552875\" class=\"AUCTION_ITEM PREVIEW\" aid=\"552875\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17992198\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA000107A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$268,205.65</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=20303264I000009000470U\" onClick = \"return showExitPopup();\" target=\"_blank\">20303264I000009000470U<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">11750 CREST CREEK DR</td></tr><tr><td class=\"AD_LBL\"></td><td class=\"AD_DTA\">RIVERVIEW, 33569</td></tr><tr><td class=\"AD_LBL\">Assessed Value:</td><td class=\"AD_DTA\">$68,437.00</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_555942\" class=\"AUCTION_ITEM PREVIEW\" aid=\"555942\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17627841\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA005705A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$203,516.77</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=\" onClick = \"return showExitPopup();\" target=\"_blank\">Property Appraiser<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">10110 WINSFORD OAK BLVD #602</td></tr><tr><td class=\"AD_LBL\"></td><td class=\"AD_DTA\">TAMPA, 33624</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_551713\" class=\"AUCTION_ITEM PREVIEW\" aid=\"551713\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17985824\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA008349A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$301,727.74</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=18282289N000000023010U\" onClick = \"return showExitPopup();\" target=\"_blank\">18282289N000000023010U<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">8736 KEY BISCAYNE DR #102</td></tr><tr><td class=\"AD_LBL\"></td><td class=\"AD_DTA\">TAMPA, 33614</td></tr><tr><td class=\"AD_LBL\">Assessed Value:</td><td class=\"AD_DTA\">$39,192.00</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_507938\" class=\"AUCTION_ITEM PREVIEW\" aid=\"507938\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17726852\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA014917A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$253,225.58</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=203103ZZZ000003108800U\" onClick = \"return showExitPopup();\" target=\"_blank\">203103ZZZ000003108800U<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">12701 BALM RIVERVIEW RD</td></tr><tr><td class=\"AD_LBL\"></td><td class=\"AD_DTA\">RIVERVIEW, 33579</td></tr><tr><td class=\"AD_LBL\">Assessed Value:</td><td class=\"AD_DTA\">$90,016.00</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_555936\" class=\"AUCTION_ITEM PREVIEW\" aid=\"555936\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=14998525\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA017760A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$395,762.17</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=222910ZZZ000004893200U\" onClick = \"return showExitPopup();\" target=\"_blank\">222910ZZZ000004893200U<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">3006 JAP TUCKER RD</td></tr><tr><td class=\"AD_LBL\"></td><td class=\"AD_DTA\">PLANT CITY, 33566</td></tr><tr><td class=\"AD_LBL\">Assessed Value:</td><td class=\"AD_DTA\">$137,239.00</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_566511\" class=\"AUCTION_ITEM PREVIEW\" aid=\"566511\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17999577\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA020290A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$337,652.38</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=\" onClick = \"return showExitPopup();\" target=\"_blank\">Property Appraiser<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">SEE FINAL JUDGMENT</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_553248\" class=\"AUCTION_ITEM PREVIEW\" aid=\"553248\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA024628A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$0.00</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=\" onClick = \"return showExitPopup();\" target=\"_blank\">Property Appraiser<\\a> </td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_505132\" class=\"AUCTION_ITEM PREVIEW\" aid=\"505132\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17710703\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA025007A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$176,852.38</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=2029252G0000004000110U\" onClick = \"return showExitPopup();\" target=\"_blank\">2029252G0000004000110U<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">1409 DEW BLOOM ROAD</td></tr><tr><td class=\"AD_LBL\"></td><td class=\"AD_DTA\">VALRICO, 33594</td></tr><tr><td class=\"AD_LBL\">Assessed Value:</td><td class=\"AD_DTA\">$67,447.00</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_524187\" class=\"AUCTION_ITEM PREVIEW\" aid=\"524187\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17818530\" onClick = \"return showExitPopup();\" target=\"_blank\">292010CA016896A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$147,760.58</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=1829144PD000001000200A\" onClick = \"return showExitPopup();\" target=\"_blank\">1829144PD000001000200A<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">1709 W PALMETTO ST</td></tr><tr><td class=\"AD_LBL\"></td><td class=\"AD_DTA\">TAMPA, 33607</td></tr><tr><td class=\"AD_LBL\">Assessed Value:</td><td class=\"AD_DTA\">$39,607.00</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_553310\" class=\"AUCTION_ITEM PREVIEW\" aid=\"553310\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17423423\" onClick = \"return showExitPopup();\" target=\"_blank\">292010CA019345A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$91,655.43</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=1928281L7000002002050U\" onClick = \"return showExitPopup();\" target=\"_blank\">1928281L7000002002050U<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">7818 NIAGARA AV </td></tr><tr><td class=\"AD_LBL\"></td><td class=\"AD_DTA\">TAMPA, 33617</td></tr><tr><td class=\"AD_LBL\">Assessed Value:</td><td class=\"AD_DTA\">$22,309.00</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div>', 'rlist':'552875,555942,551713,507938,555936,566511,553248,505132,524187,553310'}";
		String str1 = "{'retHTML':'<div id=\"AITEM_552875\" class=\"AUCTION_ITEM PREVIEW\" aid=\"552875\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17992198\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA000107A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$268,205.65</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=20303264I000009000470U\" onClick = \"return showExitPopup();\" target=\"_blank\">20303264I000009000470U<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">11750 CREST CREEK DR</td></tr><tr><td class=\"AD_LBL\"></td><td class=\"AD_DTA\">RIVERVIEW, 33569</td></tr><tr><td class=\"AD_LBL\">Assessed Value:</td><td class=\"AD_DTA\">$68,437.00</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_555942\" class=\"AUCTION_ITEM PREVIEW\" aid=\"555942\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17627841\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA005705A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$203,516.77</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=\" onClick = \"return showExitPopup();\" target=\"_blank\">Property Appraiser<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">10110 WINSFORD OAK BLVD #602</td></tr><tr><td class=\"AD_LBL\"></td><td class=\"AD_DTA\">TAMPA, 33624</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_551713\" class=\"AUCTION_ITEM PREVIEW\" aid=\"551713\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17985824\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA008349A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$301,727.74</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=18282289N000000023010U\" onClick = \"return showExitPopup();\" target=\"_blank\">18282289N000000023010U<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">8736 KEY BISCAYNE DR #102</td></tr><tr><td class=\"AD_LBL\"></td><td class=\"AD_DTA\">TAMPA, 33614</td></tr><tr><td class=\"AD_LBL\">Assessed Value:</td><td class=\"AD_DTA\">$39,192.00</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_507938\" class=\"AUCTION_ITEM PREVIEW\" aid=\"507938\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17726852\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA014917A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$253,225.58</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=203103ZZZ000003108800U\" onClick = \"return showExitPopup();\" target=\"_blank\">203103ZZZ000003108800U<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">12701 BALM RIVERVIEW RD</td></tr><tr><td class=\"AD_LBL\"></td><td class=\"AD_DTA\">RIVERVIEW, 33579</td></tr><tr><td class=\"AD_LBL\">Assessed Value:</td><td class=\"AD_DTA\">$90,016.00</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_555936\" class=\"AUCTION_ITEM PREVIEW\" aid=\"555936\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=14998525\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA017760A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$395,762.17</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=222910ZZZ000004893200U\" onClick = \"return showExitPopup();\" target=\"_blank\">222910ZZZ000004893200U<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">3006 JAP TUCKER RD</td></tr><tr><td class=\"AD_LBL\"></td><td class=\"AD_DTA\">PLANT CITY, 33566</td></tr><tr><td class=\"AD_LBL\">Assessed Value:</td><td class=\"AD_DTA\">$137,239.00</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_566511\" class=\"AUCTION_ITEM PREVIEW\" aid=\"566511\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17999577\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA020290A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$337,652.38</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=\" onClick = \"return showExitPopup();\" target=\"_blank\">Property Appraiser<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">SEE FINAL JUDGMENT</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_553248\" class=\"AUCTION_ITEM PREVIEW\" aid=\"553248\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA024628A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$0.00</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=\" onClick = \"return showExitPopup();\" target=\"_blank\">Property Appraiser<\\a> </td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_505132\" class=\"AUCTION_ITEM PREVIEW\" aid=\"505132\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17710703\" onClick = \"return showExitPopup();\" target=\"_blank\">292009CA025007A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$176,852.38</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=2029252G0000004000110U\" onClick = \"return showExitPopup();\" target=\"_blank\">2029252G0000004000110U<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">1409 DEW BLOOM ROAD</td></tr><tr><td class=\"AD_LBL\"></td><td class=\"AD_DTA\">VALRICO, 33594</td></tr><tr><td class=\"AD_LBL\">Assessed Value:</td><td class=\"AD_DTA\">$67,447.00</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_524187\" class=\"AUCTION_ITEM PREVIEW\" aid=\"524187\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17818530\" onClick = \"return showExitPopup();\" target=\"_blank\">292010CA016896A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$147,760.58</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=1829144PD000001000200A\" onClick = \"return showExitPopup();\" target=\"_blank\">1829144PD000001000200A<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">1709 W PALMETTO ST</td></tr><tr><td class=\"AD_LBL\"></td><td class=\"AD_DTA\">TAMPA, 33607</td></tr><tr><td class=\"AD_LBL\">Assessed Value:</td><td class=\"AD_DTA\">$39,607.00</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div><div id=\"AITEM_553310\" class=\"AUCTION_ITEM PREVIEW\" aid=\"553310\" rem=\"0\" isset=\"0\"><div><div class='AUCTION_STATS\"><div class='ASTAT_MSGA ASTAT_LBL\"></div><div class='ASTAT_MSGB Astat_DATA\"></div><div class='ASTAT_MSGC ASTAT_LBL\"></div> <div class='ASTAT_MSGD Astat_DATA\"></div><div class='ASTAT_MSG_SOLDTO_Label ASTAT_LBL\"></div><div class='ASTAT_MSG_SOLDTO_MSG Astat_DATA\"></div></div><div class='AUCTION_DETAILS\"> <table class=\"ad_tab\"><tr><td class=\"AD_LBL\">Auction Type:</td><td class=\"AD_DTA\">FORECLOSURE</td></tr><tr><td class=\"AD_LBL\">Case #:</td><td class=\"AD_DTA\"><a href=\"http:\\\\pubrec3.hillsclerk.com\\oncore\\showdetails.aspx?id=17423423\" onClick = \"return showExitPopup();\" target=\"_blank\">292010CA019345A001HC<\\a> </td></tr><tr><td class=\"AD_LBL\">Final Judgment Amount:</td><td class=\"AD_DTA\">$91,655.43</td></tr><tr><td class=\"AD_LBL\">Parcel ID:</td><td class=\"AD_DTA\"><a href=\"http:\\\\www.hcpafl.org\\CamaDisplay.aspx?OutputMode=Display&SearchType=RealEstate&ParcelID=1928281L7000002002050U\" onClick = \"return showExitPopup();\" target=\"_blank\">1928281L7000002002050U<\\a> </td></tr><tr><td class=\"AD_LBL\">Property Address:</td><td class=\"AD_DTA\">7818 NIAGARA AV </td></tr><tr><td class=\"AD_LBL\"></td><td class=\"AD_DTA\">TAMPA, 33617</td></tr><tr><td class=\"AD_LBL\">Assessed Value:</td><td class=\"AD_DTA\">$22,309.00</td></tr><tr><td class=\"AD_LBL\">Plaintiff Max Bid:</td><td class=\"AD_DTA ASTAT_MSGPB\">Hidden</td></tr><\\table></div></div> </div><div class='AUCTION_ITEM_SPACER\">&nbsp;</div>', 'rlist':'552875,555942,551713,507938,555936,566511,553248,505132,524187,553310'}";

		JSONObject json1 = (JSONObject) JSONSerializer.toJSON(str1);
		System.out.println(json1.get("retHTML"));
		System.out.println(json1.get("rlist"));

	}

	private static void prepareJSONObject(JSONArray array, Map<String, String> map){
		JSONObject obj = new JSONObject();
		Iterator itr = map.entrySet().iterator();
	    while (itr.hasNext()) {
			Map.Entry pairs = (Map.Entry)itr.next();
			obj.put(pairs.getKey(),pairs.getValue());
	    }
		array.add(obj);
*/
		
	}
}