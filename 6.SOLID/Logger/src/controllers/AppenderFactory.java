package controllers;

import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Factory;
import interfaces.Layout;
import models.ConsoleAppender;
import models.FileAppender;

public class AppenderFactory implements Factory<Appender> {
    private LayoutFactory layoutFactory;

    public AppenderFactory(){
        this.layoutFactory = new LayoutFactory();
    }
    @Override
    public Appender produce(String produceData) {
        String[] tokens = produceData.split("\\s+");
        String appenderType = tokens[0];
        String layoutType = tokens[1];
        Layout layout = this.layoutFactory.produce(layoutType);
        Appender appender = null;
        if (appenderType.equals("ConsoleAppender")){
            appender = new ConsoleAppender(layout);
        }else if (appenderType.equals("FileAppender")){
            appender = new FileAppender(layout);
        }
        if (tokens.length==3){
            appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
        }
        return appender;
    }
}
