package databreaker;

import java.util.Random;

public class AttributesBreaker {
    private String[] brokenAttributes;

    public String run(String s){
        String[] attributes = s.split(";");
        for(int i=1; i<attributes.length; i++){
            attributes[i] = breakAttribute(attributes[i]);
        }
        return String.join(";",attributes);
    }

    private String breakAttribute(String attribute) {
        return replaceWithAnotherData(attribute);
    }

    private boolean shouldBeBroken(){
        if(Math.random() < 0.005){
            return true;
        }else {
            return false;
        }
    }

    private String replaceWithAnotherData(String s){
        if(shouldBeBroken()){
            double random = Math.random();
            if(random < 0.25){
                return getZero();
            }else if(random < 0.5){
                return getEmptyString();
            }else if(random < 0.75){
                return getRandomInt();
            }
        }
        return s;
    }
    private String getZero(){
        return "0";
    }

    private String getEmptyString(){
        return "";
    }

    private String getRandomInt(){
        Random random = new Random();
        Integer randNumber = random.nextInt(3000);
        return randNumber + "";
    }

    private String getRandomText(){
        return "@@&%^$#324";
    }


}
