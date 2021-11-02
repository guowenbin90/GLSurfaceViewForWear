package com.example.dig4634.glsurfaceviewforwear;

import gl.modeltypes.ShadedTexturedModel;

public class Collectible extends ShadedTexturedModel {

    public boolean shown=true;

    public float segments=0;

    public float positionX=0;
    public float positionY=0;
    public float positionZ=0;

    public float speedX=0;
    public float speedY=0;
    public float speedZ=0;

    public float accelarationX=0;
    public float accelarationY=0;
    public float accelarationZ=0;

    public float angleX=0;
    public float angleZ=0;

    Collectible(){
        super();

        setXYZ(new float[]{
                0,1,0,          //(id:0)
                -0.5f,0,-0.5f,  //(id:1)
                0.5f,0,-0.5f,   //(id:2)
                0.5f,0,0.5f,    //(id:3)
                -0.5f,0,0.5f,   //(id:4)
        });


        setTriangles(new short[]{
                0,1,2, // my first triangle
                0,1,4, // left triangle
                0,3,4,
                0,2,3, // right triangle
                1,3,4, // bottom triangle 1st Half
                1,2,3  // bottom triangle 2nd Half
                });

        setUV(new float[]{
                0.5f,0.5f,  //This is the pixel of the texture that will be attached to vertex (id:0)
                0,0,        //This is the pixel of the texture that will be attached to vertex (id:1)
                0,1,        //This is the pixel of the texture that will be attached to vertex (id:2)
                1,1,        //(id:3)
                1,0         //(id:4)
                //Good update
        });

        setNormals(new float[]{0,0,1,0,0,1,0,0,1,0,0,1,0,0,-1,0,0,-1,0,0,-1,0,0,-1,1,0,0,1,0,0,1,0,0,1,0,0,-1,0,0,-1,0,0,-1,0,0,-1,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,-1,0,0,-1,0,0,-1,0,0,-1,0});


    }

    public void simulate(float perSec){

        angleX+=20*perSec;
        angleZ+=20*perSec;

        speedX+=accelarationX*perSec;
        speedY+=accelarationY*perSec;
        speedZ+=accelarationZ*perSec;

        positionX+=speedX*perSec;
        positionY+=speedY*perSec;
        positionZ+=speedZ*perSec;

        if(positionZ>-2){
            positionZ=-2-segments*4;
            shown=true;
        }


        localTransform.reset();
        localTransform.translate(positionX,positionY,positionZ);
        localTransform.rotateX(angleX);
        localTransform.rotateZ(angleZ);
        localTransform.scale(0.5f,0.5f,0.5f);
        localTransform.updateShader();
    }
}
