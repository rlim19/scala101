package fileSearcher

class FilterChecker(filter: String) {
  def matches(content: String): Boolean = content contains filter
    
  def findMatchedFiles(IOObjects: List[IOObject]): List[IOObject] = 
    for (IOObject <- IOObjects 
       if (IOObject.isInstanceOf[FileObject])
       if (matches(IOObject.name)))
    yield IOObject 
}

object FilterChecker{
  def apply(filter: String) = new FilterChecker(filter)
}