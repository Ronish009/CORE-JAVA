import java.util.Base64;
public String getDecodedAdditionalText(String additionalInfo){
    String finalAdditionalText="";
    try{
    if (additionalInfo != null && !additionalInfo.isEmpty()) {
        String[] inneradditioinalTextNeName = additionalInfo.split(",");
        if (inneradditioinalTextNeName.length > 2) {
            String encodedAdditionalValue = inneradditioinalTextNeName[2].split("/")[0];
            String decodedAdditionalValue = new String(Base64.getDecoder().decode(encodedAdditionalValue));
            finalAdditionalText = additionalInfo.replace(encodedAdditionalValue, decodedAdditionalValue);
        }
    }} catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("Already it is decoded form, no need to be encoded");
        return additionalInfo;
    }
    return "Ronish : " +finalAdditionalText;
}
void main(){
    String additionalInfo ="tnOptIntDetRaisedNotif,NON_AFFECTING,UFNTMzItNDUuMTk4LjIwN0AxMjMqISxAMzEpXjE=/AHPHG-1-3-LINE,OTS,NULL,RCV,NULL,primary,null,null,NULL,NULL|Optical Intrusion - Detected";
    System.out.println(getDecodedAdditionalText(additionalInfo));
    String additonal2 = "tnTransferLogFTRaisedNotif,NON_AFFECTING,10.43.156.169/System,COM,NULL,NULL,NULL,null,null,null,NULL,NULL";
    System.out.println(getDecodedAdditionalText(additonal2));
    System.out.println("UFNTMzItNDUuMTk4LjIwN0AxMjMqISxAMzEpXjE====".matches("^[A-Za-z0-9+/]+={0,2}$"));
    System.out.println();
    Object s=10;
    Number n12 = (Number)s;
    System.out.println(""+n12);
    System.out.println(String.valueOf(n12));
    System.out.println(Integer.valueOf(n12.toString()));
    System.out.println(n12.intValue());
    BigInteger b67 = BigInteger.valueOf(43);
    System.out.println("Big Integer" +b67);
    System.out.println(((Number)b67));
    System.out.println(((Number)b67).intValue());
    Integer t67 = ((BigInteger)b67).intValue();
    System.out.println("Integer :"+t67);
    Short a0=9;
    Integer a1=9;
    System.out.println(a1.equals(Integer.valueOf(a0)));

}