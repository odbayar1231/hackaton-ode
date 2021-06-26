package ode.nanjid.hackatonode.service;

import ode.nanjid.hackatonode.model.Supplier;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SupplierService {

    public abstract List<Supplier> getAllSuppliers();
    public abstract Page<Supplier> getAllSuppliersPaged(int pageNo);
}
