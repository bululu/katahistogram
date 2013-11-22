package katahistograma;

public interface AtributeExtractor<Entity, Atribute> {
    
    public Atribute extract (Entity entity);
    
}
