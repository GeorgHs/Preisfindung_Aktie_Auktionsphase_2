package com.georghs.vertx.pricing;

import java.util.HashMap;
import java.util.Map;

import com.georghs.vertx.pricing.participants.MarketParticipant;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class InMemoryMarketparticipantStore {
	private Map<Long, MarketParticipant> marketparticipants = new HashMap<>();

	InMemoryMarketparticipantStore () {
		marketparticipants.put(1L, new MarketParticipant(1, "Counterpart1"));
		marketparticipants.put(2L, new MarketParticipant(2, "Counterpart2"));
		marketparticipants.put(3L, new MarketParticipant(3, "Counterpart3"));
		marketparticipants.put(4L, new MarketParticipant(4, "Counterpart4"));
		marketparticipants.put(5L, new MarketParticipant(5, "Counterpart5"));
		marketparticipants.put(6L, new MarketParticipant(6, "Counterpart6"));
		marketparticipants.put(7L, new MarketParticipant(7, "Counterpart7"));
		marketparticipants.put(8L, new MarketParticipant(8, "Counterpart8"));
		marketparticipants.put(9L, new MarketParticipant(9, "Counterpart9"));
	}

	public JsonArray getAll() {
		JsonArray all = new JsonArray();
		marketparticipants.values().forEach(participant -> {
			all.add(JsonObject.mapFrom(participant));
		});
		return all;
	}

	public void add(final MarketParticipant entry) {
		marketparticipants.put((long)marketparticipants.size()+1, entry);
	}

	public MarketParticipant update(long id, final MarketParticipant marketparticipant) {
		Long key = id;
		if (key != marketparticipant.getId()) {
			throw new IllegalArgumentException("Id of MarketParticipant does not match!");
		}
		marketparticipants.put(key, marketparticipant);
		return marketparticipant;
	}

	public MarketParticipant get(long id) {
		Long key = id;
		return marketparticipants.get(key);
	}

	public Stock delete(long id) {
		Long key = id;
		return marketparticipants.remove(key);
	}
}
