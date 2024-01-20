import pb from "../../api/pocketbase";
import GuestBook from "../../pages/GuestBook/GuestBook.jsx";
import Band from "../../pages/Band/Band.jsx";

function BandRoute() {
  const band = pb.authStore.model.band;

  return band ? <GuestBook /> : <Band />;
}

export default BandRoute;
