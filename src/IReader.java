
import java.util.List;

public interface IReader {
	
	/**
	 * Gets a path and returns all document paths within the fullPath
	 * FullPath can be either a folder or a single document. 
	 * @param fullPath
	 * @return list with path documents
	 */
	public List<String> read(String fullPath); 
}
