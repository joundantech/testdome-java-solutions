import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Service de gestion d'alertes avec stockage découplé.
 * Respecte le principe DIP (Dependency Inversion).
 */
class AlertService {
    private final AlertDAO storage;

    // Injection de dépendance via constructeur
    public AlertService(AlertDAO storage) {
        this.storage = Objects.requireNonNull(storage, "AlertDAO ne peut pas être null");
    }

    /**
     * Crée une nouvelle alerte avec la date actuelle.
     * @return UUID de l'alerte générée
     */
    public UUID raiseAlert() {
        return storage.addAlert(new Date());
    }

    /**
     * Récupère le timestamp d'une alerte.
     * @param id UUID de l'alerte
     * @return Date ou null si non trouvée
     */
    public Date getAlertTime(UUID id) {
        return storage.getAlert(id);
    }
}

/**
 * Implémentation de AlertDAO avec HashMap (mémoire volatile).
 */
class MapAlertDAO implements AlertDAO {
    private final Map<UUID, Date> alerts = new HashMap<>();

    @Override
    public UUID addAlert(Date time) {
        UUID id = UUID.randomUUID();
        alerts.put(id, time);
        return id;
    }

    @Override
    public Date getAlert(UUID id) {
        return alerts.get(id);
    }
}

/**
 * Contrat pour le stockage des alertes.
 */
interface AlertDAO {
    UUID addAlert(Date time);
    Date getAlert(UUID id);
}
