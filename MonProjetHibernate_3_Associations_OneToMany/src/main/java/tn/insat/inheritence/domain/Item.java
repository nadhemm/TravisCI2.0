package tn.insat.inheritence.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.Set;

@Entity
public class Item {
	@Id
	protected Long itemId;
	protected String title;
	protected String description;
	protected Date postdate;
        
	@OneToMany (mappedBy = "item")
	protected Set<Bid> bids;
}
