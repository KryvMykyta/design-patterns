package hw11.task11_3_1;

public class VideoConversionFacade {
    public VideoFile convert(VideoFile file, Codec codec) {
        System.out.println("======= VideoConversionFacade: conversion started. =======");

        Codec sourceCodec = CodecFactory.extract(file);

        Buffer buffer = BitrateReader.read(file, sourceCodec);

        VideoFile convertedFile = BitrateReader.convert(buffer, file.getName(), codec);

        AudioMixer audioMixer = new AudioMixer();
        audioMixer.fix(convertedFile, file.getAudioBuffer());

        System.out.println("====== VideoConversionFacade: conversion completed =======");
        return convertedFile;
    }
}