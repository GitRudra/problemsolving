package org.home.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Runner {
    private HashMap<Integer, Resource> resources = new HashMap<>();

    public Iterable<Resource> getResources() {
        return this.resources.values();
    }

    public Resource acquireResource(int id) {
        Resource w = this.resources.getOrDefault(id, null);
        if (w == null) {
            w = new Resource(id);
            this.resources.put(id, w);
        }

        return w;
    }

    public void releaseResource(int id) {
        Resource w = this.resources.getOrDefault(id, null);
        if (w == null)
            throw new IllegalArgumentException();

        w.dispose();
        this.resources.remove(w);
    }

    public class Resource {
        private ArrayList<String> tasks = new ArrayList<>();

        private int id;

        public int getId() {
            return this.id;
        }

        public Iterable<String> getTasks() {
            return this.tasks;
        }

        public Resource(int id) {
            this.id = id;
        }

        public void performTask(String task) {
            if (this.tasks == null)
                throw new IllegalStateException(this.getClass().getName());

            this.tasks.add(task);
        }

        public void dispose() {
            /*Iterator<String> it = tasks.iterator();
            while(it.hasNext()){
                it.remove();
            }*/
            tasks.clear();
            this.tasks = null;
        }
    }

    public static void main(String[] args) {
        Runner d = new Runner();

        d.acquireResource(1).performTask("Task11");
        d.acquireResource(2).performTask("Task21");
        System.out.println(String.join(", ", d.acquireResource(2).getTasks()));
        d.releaseResource(2);
        d.acquireResource(1).performTask("Task12");
        System.out.println(String.join(", ", d.acquireResource(1).getTasks()));
        d.releaseResource(1);
    }
}
