package edu.isu.cs.cs2263.adapter;


import java.util.StringTokenizer;

public class PushbackTokenizerImpl implements edu.isu.cs.cs2263.adapter.PushbackTokenizer {

    StringTokenizer st = new StringTokenizer("This is my cs project"," ");

    @Override
    public String nextToken() {
        return st.nextToken();
    }

    @Override
    public boolean hasMoreTokens() {
        return st.hasMoreTokens();
    }

    @Override
    public void pushback() {

    }
}
