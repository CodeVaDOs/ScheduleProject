import React from 'react';
import Modal from '../../components/Modal/Modal';

const GroupInfoModal = ({ handler }) => {
  const { isOpen, handleModal } = handler;

  return (
    <Modal handleModal={handleModal} isOpen={isOpen} headerTitle="Информация о группе">
      <div>test</div>
    </Modal>
  );
};

export default GroupInfoModal;