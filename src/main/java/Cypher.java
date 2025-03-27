public class Cypher {
    private final static String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*'.,()[]{}/\\<>-_=+`~|:;?\" "; //Length: 95
    private final static String key = "4t5NsU!gsruf!iRSPN#DnyFLI22gvZIKp*5VZn*D";
    
    static String encrypt(String plainText) {
        String cypherText = plainText;
        
        for (int i = 0; i < cypherText.length(); i++) {
            String currentPTChar = cypherText.substring(i, i + 1);
            int currentPTIndex = chars.indexOf(currentPTChar);
            
            int currentKeyIndex = i % key.length();
            String currentKeyChar = key.substring(currentKeyIndex, currentKeyIndex + 1);
            int shiftAmount = chars.indexOf(currentKeyChar);
            
            int newIndex = (currentPTIndex + shiftAmount) % chars.length();
            String encryptedChar = chars.substring(newIndex, newIndex + 1);
            
            cypherText = cypherText.substring(0, i) + encryptedChar + cypherText.substring(i + 1, cypherText.length());
        }
        
        return cypherText;
    }
    
    static String decrypt(String cypherText) {
        String plainText = cypherText;
        
        for (int i = 0; i < plainText.length(); i++) {
            String currentCTChar = cypherText.substring(i, i + 1);
            int currentCTIndex = chars.indexOf(currentCTChar);
            
            int currentKeyIndex = i % key.length();
            String currentKeyChar = key.substring(currentKeyIndex, currentKeyIndex + 1);
            int shiftAmount = chars.indexOf(currentKeyChar);
            
            int newIndex = (Math.abs(chars.length() + (currentCTIndex - shiftAmount))) % chars.length();
            String decryptedChar = chars.substring(newIndex, newIndex + 1);
            
            plainText = plainText.substring(0, i) + decryptedChar + plainText.substring(i + 1, plainText.length());
        }
        
        return plainText;
    }
}