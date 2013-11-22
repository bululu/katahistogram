package katahistograma;

import java.util.ArrayList;

public class Katahistograma {

    public static void main(String[] args) {
        PersonLoader loader= createPersonLoader();
        HistogramBuilder<Person> builder = createBuilder(loader.load());
        HistogramViewer<String> viewer = createHistogramViewer(builder.build(createAtributeExtractor()));
        viewer.show();
    }
                
    private static PersonLoader createPersonLoader(){
        return new PersonLoader() {

            @Override
            public Person[] load() {
                ArrayList<Person> list = new ArrayList<>();
                list.add(new Person("Luis", new Email("luis@gmail.com"), Sex.MALE));
                list.add(new Person("Alba", new Email("alba@yahoo.fr"), Sex.FEMALE));
                list.add(new Person("Tony", new Email("tony@gmail.com"), Sex.MALE));
                list.add(new Person("Jackie", new Email("jackie@hotmail.com"), Sex.FEMALE));
                list.add(new Person("John", new Email("jfk@gmail.com"), Sex.MALE));
                return list.toArray(new Person[0]);                
            }
        };
    }

    private static HistogramBuilder<Person> createBuilder(Person[] collection) {
        return new HistogramBuilder<>(collection);
    }

    private static HistogramViewer<String> createHistogramViewer(Histogram<String> histogram) {
        return new ChartHistogramViewer<>(histogram);
    }

    private static AtributeExtractor<Person,String> createAtributeExtractor() {
        return new AtributeExtractor<Person,String>() {

            @Override
            public String extract(Person person) {
                return person.getEmail().getDomain();
            }
        };
    }   
}
