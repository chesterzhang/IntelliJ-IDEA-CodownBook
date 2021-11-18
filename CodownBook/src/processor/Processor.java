package processor;

import java.io.IOException;

// Responsible for processing the data of CodownBook, the core method is process()
public interface Processor {
    public void process(SourceBookData  sourceBookData) throws IOException;
}
