package models;

import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Layout;

public abstract class AppenderImpl implements Appender {
    public static final ReportLevel REPORT_LEVEL_DEFAULT = ReportLevel.INFO;
    private Layout layout;
    private ReportLevel reportLevel;
    private int messagesCount;
    private boolean canApend = false;

    public AppenderImpl(Layout layout) {
        this.layout = layout;
        this.reportLevel = AppenderImpl.REPORT_LEVEL_DEFAULT;
        this.messagesCount = 0;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    protected void incrementMessageCount(){
        ++this.messagesCount;
    }


    public AppenderImpl(Layout layout, ReportLevel reportLevel) {
        this(layout);
        this.reportLevel = reportLevel;
    }

    public Layout getLayout() {
        return layout;
    }


    protected boolean canAppend(ReportLevel reportLevel) {
        return this.reportLevel.ordinal() <= reportLevel.ordinal();
    }

    @Override
    public String toString() {
        return String.format(
                "Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),this.layout.getClass().getSimpleName(),
                this.reportLevel.toString(),this.messagesCount);
    }
}
