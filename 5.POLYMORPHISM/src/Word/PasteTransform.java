package Word;

public class PasteTransform  implements TextTransform {
    private CutTransform pasteBuff;

    public PasteTransform(CutTransform pasteBuff) {
        this.pasteBuff = pasteBuff;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        text.replace(startIndex,endIndex,this.pasteBuff.getTextToPaste().toString());
    }
}
