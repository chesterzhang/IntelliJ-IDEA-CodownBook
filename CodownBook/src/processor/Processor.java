package processor;

import java.io.IOException;

//负责处理CodownBook 的数据, 核心方法 procee()
public interface Processor {
    public void process(SourceBookData  sourceBookData) throws IOException;
}
