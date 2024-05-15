

public class Graph<T extends Comparable<T>> {
    Vertex<T> head;
    int size;

    public Graph()	{
        head=null;
        size=0;
     }
     
     public void clear() {   
        head=null;
     }
  
     public int getSize()   {
        return this.size;
     }

     public boolean hasVertex(T v)	{
        if (head==null)
           return false;
        Vertex<T> temp = head;
        while (temp!=null)	{
           if ( temp.vertexInfo.compareTo( v ) == 0 )
              return true;
           temp=temp.nextVertex;
        }
        return false;
     }

     public boolean addVertex(T v)	{
        if (hasVertex(v)==false)	{
           Vertex<T> temp=head;
           Vertex<T> newVertex = new Vertex<>(v);
           if (head==null)   
              head=newVertex;
           else {
              Vertex<T> previous=head;;
              while (temp!=null)  {
                 previous=temp;
                 temp=temp.nextVertex;
              }
              previous.nextVertex=newVertex;
           }
           size++;
           return true;
        }
        else
           return false;
     }

     
   public int getIndex(T v) {
    Vertex<T> temp = head;
    int pos=0;
    while (temp!=null)	{
       if ( temp.vertexInfo.compareTo( v ) == 0 )
          return pos;
       temp=temp.nextVertex;
       pos+=1;
    }
    return -1;
 }
 
 public ArrayList<T> getAllVertexObjects() {
    ArrayList<T> list = new ArrayList<>();
    Vertex<T> temp = head;
    while (temp!=null)	{
       list.add(temp.vertexInfo);
       temp=temp.nextVertex;
    }
    return list;
 }

 public ArrayList<Vertex<T>> getAllVertices() {
    ArrayList<Vertex<T>> list = new ArrayList<>();
    Vertex<T> temp = head;
    while (temp!=null)	{
       list.add(temp);
       temp=temp.nextVertex;
    }
    return list;
 }
 
 public T getVertex(int pos) {
    if (pos>size-1 || pos<0) 
       return null;
    Vertex<T> temp = head;
    for (int i=0; i<pos; i++)
       temp=temp.nextVertex;
    return temp.vertexInfo;
 }

 public boolean addEdge(T source, T destination)   {
    if (head==null)
       return false;
    if (!hasVertex(source) || !hasVertex(destination)) 
       return false;
    Vertex<T> sourceVertex = head;
    while (sourceVertex!=null)	{
       if ( sourceVertex.vertexInfo.compareTo( source ) == 0 )   {
          // Reached source vertex, look for destination now
          Vertex<T> destinationVertex = head;
          while (destinationVertex!=null)	{
             if ( destinationVertex.vertexInfo.compareTo( destination ) == 0 )   {
                // Reached destination vertex, add edge here
                Edge<T> currentEdge = sourceVertex.firstEdge;
                Edge<T> newEdge = new Edge<>(destinationVertex, currentEdge);
                sourceVertex.firstEdge=newEdge;
                sourceVertex.outdeg++;
                destinationVertex.indeg++;
                return true;
             }
             destinationVertex=destinationVertex.nextVertex;
          }
       }
       sourceVertex=sourceVertex.nextVertex;
    }
    return false;
 }
 
 public boolean hasEdge(T source, T destination) {
    if (head==null)
       return false;
    if (!hasVertex(source) || !hasVertex(destination)) 
       return false;
    Vertex<T> sourceVertex = head;
    while (sourceVertex!=null)	{
       if ( sourceVertex.vertexInfo.compareTo( source ) == 0 )   {
          // Reached source vertex, look for destination now 
          Edge<T> currentEdge = sourceVertex.firstEdge;
          while (currentEdge != null) {
             if (currentEdge.toVertex.vertexInfo.compareTo(destination)==0) 
             // destination vertex found 
                return true;
             currentEdge=currentEdge.nextEdge;
          }
       }
       sourceVertex=sourceVertex.nextVertex;
    }
    return false;
 } 

 public boolean addUndirectedEdge(T source, T destination)   {
    if (head==null)
       return false;
    if (!hasVertex(source) || !hasVertex(destination)) 
       return false;
    Vertex<T> sourceVertex = head;
    while (sourceVertex!=null)	{
       if ( sourceVertex.vertexInfo.compareTo( source ) == 0 )   {
          // Reached source vertex, look for destination now
          Vertex<T> destinationVertex = head;
          while (destinationVertex!=null)	{
             if ( destinationVertex.vertexInfo.compareTo( destination ) == 0 )   {
                // Reached destination vertex, add edge here
                Edge<T> currentEdge = sourceVertex.firstEdge;
                Edge<T> currentEdge1 = destinationVertex.firstEdge;
                Edge<T> newEdge = new Edge<>(destinationVertex, currentEdge);
                Edge<T> newEdge1 = new Edge<>(sourceVertex, currentEdge1);
                sourceVertex.firstEdge=newEdge;
                destinationVertex.firstEdge=newEdge1;
                sourceVertex.outdeg++;
                sourceVertex.indeg++;
                destinationVertex.indeg++;
                destinationVertex.outdeg++;
                return true;
             }
             destinationVertex=destinationVertex.nextVertex;
          }
       }
       sourceVertex=sourceVertex.nextVertex;
    }
    return false;
 }

}
