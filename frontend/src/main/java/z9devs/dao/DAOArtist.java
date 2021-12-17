package z9devs.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import z9devs.entities.Artist;

@Stateless
public class DAOArtist implements DAO {
	
	@PersistenceContext(unitName="media_archive_PU")
	EntityManager em;

	public void create(Object o) 
	{
		em.persist(o);
	}

	public List<Object> getAll() 
	{
		return null;
	}
	
	public Object getById(int id) 
	{
		Artist a = em.find(Artist.class, id);
		// Used to get album list, because of FetchType.Lazy
		// need to find a better way to solve this issue
		a.getAlbums().size();
		return a;
		
	}

	public void update(Object o) 
	{
		Artist a = em.find(Artist.class, ((Artist) o).getId());
		a.setName(((Artist) o).getName());
	}

	public boolean deleteById(int id) 
	{
		Artist a = em.find(Artist.class, id);
		if(a != null) 
		{
			System.out.println(a != null);
			System.out.println("Dentro");
			em.remove(a);
			return true;
		}
		return false;
	}

}
