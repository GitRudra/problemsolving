/*
// Java program for design
public class Server {
    ArrayList<Machine> machines = new ArrayList<Machine>();
}


public class Storage {
    ArrayList<VideoMachine> machines = new ArrayList<VideoMachine>();
}

public class Machine {
    public ArrayList<User> users = new ArrayList<User>();
    public int machineID;
}

public class VideoMachine {
    public ArrayList<Video> videos = new ArrayList<Video>();
    public int machineID;
}

public class User {
    private ArrayList<Integer> videos;
    private int userID;
    private int machineID;
    private String information;
    private Server server = new Server();
    private Storage storage = new Storage();

    public User(int userID, int machineID) {
        this.userID = userID;
        this.machineID = machineID;
        videos = new ArrayList<Integer>();
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public getID() {
        return userID;
    }

    public int getMachineID() {
        return machineID;
    }

    public void addVideo(int id) {
        videos.add(id);
    }

    public int[] getVideos() {
        int[] temp = new int[videos.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = videos.get(i);
        }
        return temp;
    }

    public User lookUpVideo(int machineID, int ID) {
        for (Machine m : storage.machine) {
            if (m.machineID = machineID) {
                for (Video video : m.video) {
                    if (video.videoID = ID) {
                        return video;
                    }
                }
            }
        }
        return null;
    }
}

public class Video {
    private int machineID;
    private int videoID;
    private String videoPath;

    public Video(int machineID, int videoID, String photoPath) {
        this.machineID = machineID;
        this.videoID = videoID;
        this.videoPath = videoPath;
    }

    public int getMachineID() {
        return machineID;
    }

    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }

    public int getVideoID() {
        return videoID;
    }

    public int getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
}
*/
