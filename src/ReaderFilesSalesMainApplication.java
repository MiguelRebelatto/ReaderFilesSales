import service.TotalizatorService;

import java.io.IOException;

public class ReaderFilesSalesMainApplication {

    public static void main(String[] args) throws IOException {
        TotalizatorService ts = new TotalizatorService();
        ts.readFiles();
    }

}
