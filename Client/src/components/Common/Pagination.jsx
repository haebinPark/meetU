import { styled } from "styled-components";
import Button from "./Button.jsx";

const PaginationWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 20px 0;
`;

const CurrentPage = styled.span`
  font-size: 16px;
`;

export default function Pagination({ currentPage, totalPages, onPageChange }) {
  const handlePrevious = () => {
    if (currentPage > 1) {
      onPageChange(currentPage - 1);
    }
  };

  const handleNext = () => {
    if (currentPage < totalPages) {
      onPageChange(currentPage + 1);
    }
  };

  return (
    <PaginationWrapper>
      <Button size="sm" onClick={handlePrevious}>
        이전
      </Button>
      <CurrentPage>
        {currentPage} / {totalPages}
      </CurrentPage>
      <Button size="sm" onClick={handleNext}>
        다음
      </Button>
    </PaginationWrapper>
  );
}
