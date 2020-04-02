
import java.util.List;

import javax.inject.Inject;


public class IndexHandler {
	
	IReader reader;
	IFactoryParser factoryParser;
	IIndexer indexer;
	ITokenizer tokenizer;
	
	public IndexHandler(IReader reader,IFactoryParser factoryParser, 
			ITokenizer tokenizer ,IIndexer indexer){
		this.reader = reader;
		this.factoryParser = factoryParser;
		this.indexer = indexer;
		this.tokenizer = tokenizer;
	}
	

	public void index(String fullPath) {
		//Reader reads all files on the path.
		List<String> filePaths = reader.read(fullPath);
		//Per file we create a parser depending on the extension using a Factory. We return the data from the file.
		for(String file : filePaths) {
			String docContent = factoryParser.getParser(file).parse(file);
			List<String> tokens = this.tokenizer.tokenize(docContent);
			indexer.index(file, tokens);
		}	
	}
}
