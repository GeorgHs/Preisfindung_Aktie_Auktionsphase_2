package com.georghs.vertx.pricing.repositories;

import java.util.ArrayList;
import java.util.List;

import com.georghs.vertx.pricing.participants.AbstractMarketParticipant;

public class InMemoryMarketParticipantRepository implements MarketParticipantRepository {

	private List<AbstractMarketParticipant> marketParticipants;

	public InMemoryMarketParticipantRepository() {
		marketParticipants = new ArrayList<>();
	}

	@Override
	public List<AbstractMarketParticipant> getAll() {
		return new ArrayList<>(marketParticipants);
	}

	@Override
	public void add(AbstractMarketParticipant entry) {
		marketParticipants.add(entry);
	}

	@Override
	public AbstractMarketParticipant update(int id, AbstractMarketParticipant marketparticipant) {
		var result = get(id);

		result.setName(marketparticipant.getName());
		result.setOrders(marketparticipant.getOrders());

		return result;
	}

	@Override
	public AbstractMarketParticipant get(int id) {
		var result = marketParticipants.stream()
			.filter((participant) -> participant.getId() == id)
			.findFirst();

		if (result.isEmpty()) {
			throw new IllegalArgumentException("Id of MarketParticipant does not match or is null!");
		}
		return result.get();
	}

	@Override
	public boolean delete(int id) {
		var result = get(id);
		return marketParticipants.remove(result);
	}

}
