import java.io.IOException;

class Thr implements Runnable
{
    private final int pos;

    worker wor;

    public Thr(worker wor,int pos) {
        this.wor = wor;
        this.pos =pos;

    }




    public void run()
    {



                    try {
                            wor.parse(pos);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }





    }
}