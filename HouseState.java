package java_bootcamp;

import com.google.common.collect.ImmutableList;
import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HouseState implements ContractState {
    private String address;
    private Party owner;

    public HouseState(String address, Party owner) {
        this.address = address;
        this.owner = owner;
    }

    public static void main(String[] args){
        Party joel = null;
        HouseState state = new HouseState("1 low Moor Avenue, Berkshire",joel);
    }

    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return ImmutableList.of();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Party getOwner() {
        return owner;
    }
}
