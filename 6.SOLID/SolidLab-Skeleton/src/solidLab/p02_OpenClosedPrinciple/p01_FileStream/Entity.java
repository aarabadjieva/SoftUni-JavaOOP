package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class Entity {
    private int length;
    private int sent;

    protected int getLength() {
        return this.length;
    }

    protected void setLength(int length) {
        this.length = length;
    }

    protected int getSent() {
        return this.sent;
    }

    protected void setSent(int sent) {
        this.sent = sent;
    }

}
