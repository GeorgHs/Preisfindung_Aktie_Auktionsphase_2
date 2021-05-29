package com.georghs.vertx.pricing.repositories;

import java.util.List;

import com.georghs.vertx.pricing.components.Stock;
import com.georghs.vertx.pricing.participants.AbstractMarketParticipant;

import io.vertx.core.json.JsonArray;

public interface MarketParticipantRepository {
	List<AbstractMarketParticipant> getAll();
	void add(final AbstractMarketParticipant entry);
	AbstractMarketParticipant update(int id, final AbstractMarketParticipant marketparticipant);
	AbstractMarketParticipant get(int id);
	boolean delete(int id);
}
