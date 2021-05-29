package com.georghs.vertx.pricing.InMemories;

import java.util.HashMap;
import java.util.Map;

import com.georghs.vertx.pricing.components.Stock;
import com.georghs.vertx.pricing.participants.Broker;
import com.georghs.vertx.pricing.participants.AbstractMarketParticipant;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class InMemoryMarketparticipantStore {
	private Map<Long, AbstractMarketParticipant> marketparticipants = new HashMap<>();

	InMemoryMarketparticipantStore () {
		marketparticipants.put(1L, new Broker(1, "Counterpart1"));
		marketparticipants.put(2L, new AbstractMarketParticipant(2, "Counterpart2"));
		marketparticipants.put(3L, new AbstractMarketParticipant(3, "Counterpart3"));
		marketparticipants.put(4L, new AbstractMarketParticipant(4, "Counterpart4"));
		marketparticipants.put(5L, new AbstractMarketParticipant(5, "Counterpart5"));
		marketparticipants.put(6L, new AbstractMarketParticipant(6, "Counterpart6"));
		marketparticipants.put(7L, new AbstractMarketParticipant(7, "Counterpart7"));
		marketparticipants.put(8L, new AbstractMarketParticipant(8, "Counterpart8"));
		marketparticipants.put(9L, new AbstractMarketParticipant(9, "Counterpart9"));
	}

	public JsonArray getAll() {
		JsonArray all = new JsonArray();
		marketparticipants.values().forEach(participant -> {
			all.add(JsonObject.mapFrom(participant));
		});
		return all;
	}

	public void add(final AbstractMarketParticipant entry) {
		marketparticipants.put((long)marketparticipants.size()+1, entry);
	}

	public AbstractMarketParticipant update(long id, final AbstractMarketParticipant marketparticipant) {
		Long key = id;
		if (key != marketparticipant.getId()) {
			throw new IllegalArgumentException("Id of MarketParticipant does not match!");
		}
		marketparticipants.put(key, marketparticipant);
		return marketparticipant;
	}

	public AbstractMarketParticipant get(long id) {
		Long key = id;
		return marketparticipants.get(key);
	}

	public Stock delete(long id) {
		Long key = id;
		return marketparticipants.remove(key);
	}
}
