
public class FactoryParser implements IFactoryParser {
	
	@Override
	public IParser getParser(String path) {
		Extensions extension =  getExtension(path);
		if (extension == Extensions.PDF)
			return new PdfParser();
		return null;
	}
	
	private Extensions getExtension(String path) {
		return Extensions.PDF;
	}
}	
