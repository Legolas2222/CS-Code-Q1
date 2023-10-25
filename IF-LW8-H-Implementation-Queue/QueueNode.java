public class QueueNode<SubContentType> {
        private SubContentType contentObj;
        private QueueNode<SubContentType> nextNode = null;

        public QueueNode(SubContentType t) {
            this.contentObj = t;
        }

        public QueueNode<SubContentType> getNext() {
            return this.nextNode;
        }

        public void setNext(QueueNode<SubContentType> qn) {
            this.nextNode = qn;
        }

        public SubContentType getContent() {
            return this.contentObj;
        }
    }
