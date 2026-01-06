void main(){
 String test = "ODUFLEX|";
    String srcPrimaryState=test.substring(test.indexOf("|")+1);
    System.out.println(PRIMARYSTATE.getPrimaryStateValueFromName(srcPrimaryState));
    String[] arr = {"",null};
    String srcVsidPktName = arr[1].toString();
    String srcVSID=srcVsidPktName.substring(0,srcVsidPktName.indexOf("|"));
    System.out.println(srcVSID);
}

 enum PRIMARYSTATE {
     IS_NR("In Service"),
     IS_ANR("In Service, AINS"),
     OOS_AUMA("Out Of Service "),
     OOS_AU("Out Of Service - Autonomous"),
     OOS_MA("Out Of Service - Auto and Mgmt"),
     MT("Maintenance"),
     UNKNOWN("--");
     private String text;

     PRIMARYSTATE(String text) {
         this.text = text;
     }

     public String getText() {
         return this.text;
     }

     public static PRIMARYSTATE fromName(String text) {
         PRIMARYSTATE temp = PRIMARYSTATE.UNKNOWN;
         if (text != null) {
             for (PRIMARYSTATE s : PRIMARYSTATE.values()) {
                 if (text.equalsIgnoreCase(s.text)) {
                     temp = s;
                 }
             }
         }
         return temp;
     }

     public static String getPrimaryStateFromValue(int value) {
         String retVal = PRIMARYSTATE.UNKNOWN.getText();
         PRIMARYSTATE[] values = PRIMARYSTATE.values();
         for (PRIMARYSTATE primarystate : values) {
             int ordinal = primarystate.ordinal();
             if (value == ordinal) {
                 retVal = primarystate.getText();
             }
         }
         return retVal;
     }
     public static String getPrimaryStateValueFromName(String text) {
         String retVal = PRIMARYSTATE.UNKNOWN.getText();
         if(text==null)
         {
             return retVal;
         }
         String inputName=text.replace("-", "_");
         PRIMARYSTATE[] values = PRIMARYSTATE.values();
         for (PRIMARYSTATE primarystate : values) {
             String name = primarystate.name();
             if (inputName.equalsIgnoreCase(name)) {
                 retVal = primarystate.getText();
             }
         }

         return retVal;
     }
 }

