import BandList from "../../components/Band/BandList.jsx";
import BandSearch from "../../components/Band/BandSearch.jsx";
import PageTitle from "../../components/Common/PageTitle.jsx";

function Band() {
  return (
    <>
      <section>
        <PageTitle pageTitle="반 검색" />
        <BandSearch />
      </section>
      <section>
        <PageTitle pageTitle="반 목록" />
        <BandList />
      </section>
    </>
  );
}

export default Band;
