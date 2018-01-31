import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Set;

public class selectopera {

    public final static int BYTE_BUFFER_SIZE=8192;

    public final static ByteBuffer CLIENT_BYTE_BUFFER=ByteBuffer.allocate(BYTE_BUFFER_SIZE);

    public final static int DEFAULT_PORT =8888;

    private static Selector createSelector() throws IOException
    {
        ServerSocketChannel socketChannel =ServerSocketChannel.open();
        Selector selector =Selector.open();
        socketChannel.socket().bind(new InetSocketAddress(DEFAULT_PORT));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        return selector;
    }

    public static void main(String[] args) throws IOException {
        Selector selector = createSelector();
        while (true)
        {
            selector.select();
            Set<SelectionKey> selectionKeySet =selector.selectedKeys();
            for(SelectionKey selectionKey:selectionKeySet)
            {
                //process
            }
        }

    }




}
