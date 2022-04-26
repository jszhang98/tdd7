package commonmatching;

import tools.Indicator;

public class CommonMatchingChar {
    public boolean isMatch(String toBeMatched, String matchedStrWithChar) {
        boolean result = false;
        if(toBeMatched.equals(matchedStrWithChar) && matchedStrWithChar.indexOf('*')==-1 && matchedStrWithChar.indexOf('.')==-1){
            return true;
        }
        if(toBeMatched.length()<matchedStrWithChar.length()){
            return false;
        }

        if(matchedStrWithChar.indexOf('*')==-1 && toBeMatched.length()<matchedStrWithChar.length()){
            return false;
        }


        char[] source = toBeMatched.toCharArray();
        char[] matched = matchedStrWithChar.toCharArray();
        char[] finalStr = new char[source.length];
        char theLastStar = '-';
        int j=0;
        for(int i=0;i<source.length;i++){
            if (j>=matched.length){break;}
            if(source[i]==matched[j]){
                theLastStar=matched[j];
                finalStr[i]=source[i];
                j++;
            }else if (matched[j]=='.'){
                theLastStar=matched[j];
                finalStr[i]=source[i];
                j++;
            }else if(matched[j]=='*'){
                theLastStar=matched[j];
                finalStr[i]=source[i];
            }else if(source[i]!=matched[j]){
               if(theLastStar=='.'){
                   finalStr[i]='.';
                   j++;
               }
               if(theLastStar=='*'){
                    finalStr[i]=theLastStar;
               }
            }
        }


        return String.valueOf(finalStr).equals(toBeMatched);
    }

}
