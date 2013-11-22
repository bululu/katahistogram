package katahistograma;

public class HistogramBuilder<T>{
    private T[] collection;
    
        public HistogramBuilder(T[] collection) {
        this.collection = collection;
    }

    public <A> Histogram<A> build(AtributeExtractor<T,A> extractor){
        Histogram<A> histogram = new Histogram<>();
        for (T item : collection){           
            A attribute= extractor.extract(item);
            histogram.put(attribute,histogram.get(attribute)+1);        
        }
        return histogram;
    }
}

