package org.home.java;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;


public class Friend {
    private Collection<Friend> friends;
    private String email;
    HashSet<Friend> visitedFriends = new HashSet<>();

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
        if(this.getEmail().equals(friend.getEmail())){
            return true;
        }
        boolean isExist = false;
        for(Friend f:friends){
            /*if(friend.friends.contains(f)){
                isExist = true;
                break;
            }*/
            if(!visitedFriends.contains(f)){
                visitedFriends.add(f);
                isExist = f.canBeConnected(friend);
            }

        }


        return isExist;
    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");
        Friend d = new Friend("D");
        Friend e = new Friend("E");

        a.addFriendship(b);
        a.addFriendship(d);
        d.addFriendship(e);
        b.addFriendship(c);

        System.out.println(a.canBeConnected(c));
        System.out.println(d.canBeConnected(c));


    }
}
