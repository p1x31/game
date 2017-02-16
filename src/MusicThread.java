
class MusicThread extends Thread {

    byte tempBuffer[] = new byte[320];

    public void run() {

        try {
            int cnt;
            MusicPlay.hasStop = false;

            // read music to temp buffer
            while ((cnt = MusicPlay.audioInputStream.read(tempBuffer, 0,tempBuffer.length)) != -1)
            {
            	if (MusicPlay.isStop)
            	break;

                if (cnt > 0) {
                    // write to temp buffer
                    MusicPlay.sourceDataLine.write(tempBuffer, 0, cnt);
                    }
            }

            MusicPlay.sourceDataLine.drain();
            MusicPlay.sourceDataLine.close();
            MusicPlay.hasStop = true;

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);

        }

    }

}
