package chain_of_responsibility.requirements;

public class Mai {

    public static void main(String[] args) {
        LogProcessor logger = new WarnProcessor(new ErrorProcessor(new InfoProcessor(null)));
        logger.doLog(LogEnum.CHECK,"Logger test");
    }
}
