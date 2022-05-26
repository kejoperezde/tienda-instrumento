import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
public class AddContenido extends ObjectOutputStream{

    public AddContenido() throws IOException, SecurityException {
        super();
    }
    
    public AddContenido(OutputStream out) throws IOException{
        super(out);
    }
    
    @Override
    protected void writeStreamHeader()throws IOException{
        reset();
    }
}
