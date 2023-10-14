package Model;

public class Complex {

    private float re;
    private float im;

    public Complex(float re, float im){
        this.re=re;
        this.im=im;
    }

    public float getRe(){
        return this.re;
    }

    public float getIm(){
        return this.im;
    }

    public void setRe(float re){
        this.re=re;
    }

    public void setIm(float im){
        this.im=im;
    }

    public void subtract(Complex other){
        this.re-=other.re;
        this.im-=other.im;
    }

    public void multiply(Complex other){
        float old_re=this.re;
        float old_im=this.im;
        this.re=old_re*other.re-old_im*other.im;
        this.im=old_re* other.im+old_im* other.re;
    }

    public void add(Complex other){
        this.re+=other.re;
        this.im+=other.im;
    }

    public void divisionBy(Complex other){
        float old_re=this.re;
        float old_im=this.im;

        //
        this.re=old_re*other.re+old_im*other.im;
        this.im=old_im* other.re-old_re*other.im;

        //
        this.re/= other.re* other.re+ other.im* other.im;
        this.im/= other.re* other.re+ other.im* other.im;


    }


}
