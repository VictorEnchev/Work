package designpatterns.calculator;

public class Calculator {
    public double executeCommand(Command command){
        return command.execute();
    }
}
