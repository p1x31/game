class MusicThread extends Thread {

    byte tempBuffer[] = new byte[320];

    public void run() {

        try {
            int cnt;
            Music.hasStop = false;

            // read music to temp buffer
            while ((cnt = Music.audioInputStream.read(tempBuffer, 0,tempBuffer.length)) != -1)
            {
            	if (Music.isStop)
            	break;

                if (cnt > 0) {
                    // write to temp buffer
                    Music.sourceDataLine.write(tempBuffer, 0, cnt);
                    }
            }

            Music.sourceDataLine.drain();
            Music.sourceDataLine.close();
            Music.hasStop = true;

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);

        }

    }

}
