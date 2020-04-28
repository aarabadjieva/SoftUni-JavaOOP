package Word;

public class CutTransform implements TextTransform {
    private  StringBuilder textToPaste;
    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        this.textToPaste = new StringBuilder();
        this.textToPaste.delete(0,textToPaste.length());
        if (startIndex==endIndex){
            return;
        }
        this.textToPaste.append(text,startIndex,endIndex);
        text.delete(startIndex,endIndex);
    }

    public StringBuilder getTextToPaste() {
        return textToPaste;
    }
}
