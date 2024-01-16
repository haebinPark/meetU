import BandList from "../../components/Band/BandList.jsx";
import BandSearch from "../../components/Band/BandSearch.jsx";
import PageDescription from "../../components/Common/PageDescription.jsx";
import PageTitle from "../../components/Common/PageTitle.jsx";

function Band() {
  return (
    <>
      <section style={{ textAlign: "center" }}>
        <PageTitle pageTitle="반 검색" />
        <PageDescription> 우리 반을 찾아보세요! </PageDescription>
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
