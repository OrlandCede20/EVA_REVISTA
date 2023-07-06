package com.example.myapplication.Modelos;

public class Noticia {
    private String titulo;
    private String subtitulo;
    public Noticia(String tit, String subtitulo){
        this.titulo = tit;
        this.subtitulo = subtitulo;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getSubtitulo(){
        return subtitulo;
    }
    @Override
    public String toString(){
        return titulo+" "+ subtitulo;
    }
}
